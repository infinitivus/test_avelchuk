package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.twirl.api.Html;

import service.IPersonService;

import javax.inject.Inject;

public class PersonController extends Controller {

    private final Form<PersonData> form;
    private final MessagesApi messagesApi;
    private final IPersonService service;
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Inject
    public PersonController(FormFactory formFactory, MessagesApi messagesApi, IPersonService service) {
        this.form = formFactory.form(PersonData.class);
        this.messagesApi = messagesApi;
        this.service = service;

    }

    // GET  Контроллер страницы с формой ввода емайла, пароля и кнопками
    public Result login(Http.Request request) {
        return ok(views.html.login.render(form, request, messagesApi.preferred(request)));
    }

    // POST  Контроллер обработки данных полученных с начальной страницы по нажатиб кнопки вход
    public Result checkPerson(Http.Request checkRequest) {
        final Form<PersonData> boundForm = form.bindFromRequest(checkRequest);
        if (errorInput(boundForm)) {                                                                 // проверка на ошибку ввода информации
            return badRequest(views.html.login.render(boundForm, checkRequest, messagesApi.preferred(checkRequest)));
        } else {
            PersonData data = boundForm.get();
            int numRecord = service.checkDuplicationEmail(data.getEmail());                          // получение номера записи,если она есть +
            String passwordEncoder = service.encodingPassword(data.getPassword());
            if (numRecord >= 0 && service.checkPassword(passwordEncoder, numRecord)) {               //сравнение введенного емайла и пароля с данными +
                boolean authorisation = service.getAuthorisation(numRecord);                           //получение данных о авторизации пользователя
                return ok(Html.apply("<h3>Пользователь:" + data.getEmail() +
                        "<br>Авторизация: " + authorisation + "</h3>"
                        + "<button onclick=\"window.location.href = 'http://localhost:9000/';\">Выход</button>")); // вернуть  страницу с емаил, статусом авторизации и кнопкой выход (main)
            } else {
                return badRequest(views.html.login.render(boundForm, checkRequest, messagesApi.preferred(checkRequest))); // вернуть страницу аутентификации с сообщением что нет
            }
        }
    }

    // POST  Контроллер обработки данных полученных с начальной страницы по нажатию кнопки регистрация
    public Result registrationPerson(Http.Request regRequest) {
        final Form<PersonData> boundForm = form.bindFromRequest(regRequest);
        if (errorInput(boundForm)) {                                                                            // проверка на ошибку ввода информации
            return badRequest(views.html.login.render(boundForm, regRequest, messagesApi.preferred(regRequest)));
        } else {
            if (service.checkDuplicationEmail(boundForm.get().getEmail()) >= 0) {
                return redirect(routes.PersonController.login()).flashing("info", "Widget added!");               // возвращаем на страницу аутентификации с ошибкой "такой емайл уже есть"
            } else {
                PersonData data = boundForm.get();
                service.savePerson(data);// записать пользователя
                service.sendMessageEmailRegistration(data.getEmail(), service.encodingPassword(data.getPassword()));  // отправить пользователю письмо для авторизации
                return ok(Html.apply("<h3>Пользователь зарегистрирован:" + data.getEmail() + "<br>Авторизация: False <br>Для авторизации пройдите по ссылке на почте </h3>"
                        + "<button onclick=\"window.location.href = 'http://localhost:9000/';\">Выход</button>")); // вернуть  страницу с емаил, статусом авторизации и кнопкой выход (main)
            }
        }
    }

    //POST Контроллер обработки запроса авторизации
    public Result authorisationPerson(Http.Request authRequest) {
        final Form<PersonData> boundForm = form.bindFromRequest(authRequest);
        PersonData data = boundForm.get();
        int numRecord = service.checkDuplicationEmail(data.getEmail());
        if (numRecord >= 0 && service.checkPassword(data.getPassword(), numRecord)) {
            service.setAuthorisation(data, numRecord);
            return ok(Html.apply("<h3>Пользователь:" + data.getEmail() +
                    "<br>Авторизация: Авторизирован/h3>"
                    + "<button onclick=\"window.location.href = 'http://localhost:9000/';\">Выход</button>"));
        } else {
            return badRequest(views.html.login.render(boundForm, authRequest, messagesApi.preferred(authRequest)));
        }
    }

    // проверка на правильность ввода данных пользователем
    private boolean errorInput(Form<PersonData> form) {
        if (form.hasErrors()) {
            logger.error("errors = {}", form.errors());
            return true;
        }
        return false;
    }
}
