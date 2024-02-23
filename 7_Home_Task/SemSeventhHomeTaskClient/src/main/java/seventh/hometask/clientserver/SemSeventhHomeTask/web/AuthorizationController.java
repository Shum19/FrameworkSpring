package seventh.hometask.clientserver.SemSeventhHomeTask.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


import java.security.Principal;
import java.util.Base64;

@Controller
public class AuthorizationController {
    @Autowired
    private OAuth2AuthorizedClientService auth2AuthorizedClientService;


    @GetMapping
    public String getCat(Model model, Principal principal) {
        // форма запроса
        RestTemplate template = new RestTemplate();
        // Получение access токена
        String accessToken = auth2AuthorizedClientService
                .loadAuthorizedClient("reg-client", principal.getName())
                .getAccessToken().getTokenValue();
        // Создаем заголовок и помещаем в него токен авторизации
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        // Отправляем запрос
        ResponseEntity<byte[]> response =
                template.exchange("http://localhost:8081/cat",
                        HttpMethod.GET, entity, byte[].class);
        // Преобразование изображения
        String base64Image = Base64.getEncoder().encodeToString(response.getBody());

        model.addAttribute("cat",base64Image);

        return "cat-page";
    }

    //    private final WebClient webClient;
//    private final String messagesBaseUri;
//    public AuthorizationController(WebClient webClient,
//                                   @Value("${messages.base-uri}") String messagesBaseUri) {
//        this.webClient = webClient;
//        this.messagesBaseUri = messagesBaseUri;
//    }
//
//    @GetMapping(value = "/authorize", params = "grant_type=authorization_code")
//    public String authorizationCodeGrant(Model model,
//                                         @RegisteredOAuth2AuthorizedClient("messaging-client-authorization-code")
//                                         OAuth2AuthorizedClient authorizedClient) {
//
//        String[] messages = this.webClient
//                .get()
//                .uri(this.messagesBaseUri)
//                .attributes(oauth2AuthorizedClient(authorizedClient))
//                .retrieve()
//                .bodyToMono(String[].class)
//                .block();
//        model.addAttribute("messages", messages);
//
//        return "index";
//    }
//    // '/authorized' is the registered 'redirect_uri' for authorization_code
//    @GetMapping(value = "/authorized", params = OAuth2ParameterNames.ERROR)
//    public String authorizationFailed(Model model, HttpServletRequest request) {
//        String errorCode = request.getParameter(OAuth2ParameterNames.ERROR);
//        if (StringUtils.hasText(errorCode)) {
//            model.addAttribute("error",
//                    new OAuth2Error(
//                            errorCode,
//                            request.getParameter(OAuth2ParameterNames.ERROR_DESCRIPTION),
//                            request.getParameter(OAuth2ParameterNames.ERROR_URI))
//            );
//        }
//
//        return "index";
//    }
//
//    @GetMapping(value = "/authorize", params = "grant_type=client_credentials")
//    public String clientCredentialsGrant(Model model) {
//        System.out.println("before");
//        String[] messages = this.webClient
//                .get()
//                .uri(this.messagesBaseUri)
//                .attributes(clientRegistrationId("messaging-client-client-credentials"))
//                .retrieve()
//                .bodyToMono(String[].class)
//                .block();
//        model.addAttribute("messages", messages);
//
//        return "index";
//    }
}
