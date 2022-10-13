package com.cozz.deyou.controller;

import com.cozz.deyou.NativeDecrypt;
import com.cozz.deyou.cipher.AESUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cipher")
@CrossOrigin(origins = "*")
public class CipherController {
    @PostMapping(value = "/decrypt-token")
    @ResponseBody
    public String decryptToken(@RequestBody String enToken) {
        String midDecryptedToken = AESUtils.m3394c(enToken);
        return NativeDecrypt.decrypt(midDecryptedToken);
    }

    @PostMapping(value="/encrypt-body")
    @ResponseBody
    public String encryptBody(@RequestBody String body) throws Exception {
        return AESUtils.m3399a(body, "d7b85f6e214abcda");
    }
}
