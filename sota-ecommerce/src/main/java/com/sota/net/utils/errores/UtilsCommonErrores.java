package com.sota.net.utils.errores;

import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilsCommonErrores {
    public static boolean comporbarBindingResult(BindingResult result, Map<String, Object> response) {
        if (!result.hasErrors()) {
            return false;
        }
        List<String> errors = result.getFieldErrors().stream()
                .map(err -> "El campo:'" + err.getField() + "' " + err.getDefaultMessage())
                .collect(Collectors.toList());
        response.put("errors", errors);
        return true;
    }

}
