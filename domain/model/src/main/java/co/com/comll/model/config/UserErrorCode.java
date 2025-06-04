package co.com.comll.model.config;

import lombok.Getter;

@Getter
public enum UserErrorCode {

        CRB00("CR-B000", "ERROR CREANDO NUEVO USUARIO, YA EXISTE");

        private String errorCode;
        private String errorTitle;

    UserErrorCode(String errorCode, String errorTitle) {
        this.errorCode = errorCode;
        this.errorTitle = errorTitle;
    }
}
