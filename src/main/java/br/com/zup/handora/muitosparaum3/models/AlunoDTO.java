package br.com.zup.handora.muitosparaum3.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AlunoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String bootcamp;

    public AlunoDTO() {}

    public AlunoDTO(@NotBlank String nome, @NotBlank @Email String email,
                    @NotBlank String bootcamp) {
        this.nome = nome;
        this.email = email;
        this.bootcamp = bootcamp;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getBootcamp() {
        return bootcamp;
    }

}
