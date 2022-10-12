package com.cozz.deyou.controller;

import com.cozz.deyou.NativeDecrypt;
import com.cozz.deyou.cipher.AESUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CipherController {
    @PostMapping(value = "/api/cipher/decrypt-token")
    @ResponseBody
    public String decryptToken(@RequestBody String enToken) {
        String midDecryptedToken = AESUtils.m3394c(enToken);
        return NativeDecrypt.decrypt(midDecryptedToken);
    }
}
