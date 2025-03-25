package com.email.writer.app;

//import lombok.AllArgsConstructor;............new
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//"api/email/generate"
@RestController
@RequestMapping("api/email")
//@AllArgsConstructor......new
@CrossOrigin(origins = "*")
public class EmailGeneratorController {
    private final EmailGeneratorService emailGeneratorService;
//new
    public EmailGeneratorController(EmailGeneratorService emailGeneratorService) {
        this.emailGeneratorService = emailGeneratorService;
    }
//new close
    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){
        String response = emailGeneratorService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }
}
