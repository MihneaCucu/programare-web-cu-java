package ro.example.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.example.lab3.scope.RequestInfo;

@Controller
public class RequestInfoController {

    private final RequestInfo requestInfo;

    public RequestInfoController(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    @GetMapping("/request-info")
    @ResponseBody
    public String getRequestInfo() {
        return "Request ID: " + requestInfo.getId();
    }
}
