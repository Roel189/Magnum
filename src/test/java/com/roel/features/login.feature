@login
Feature: Login Functionality

  Scenario: Verificar presenca dos campos
    Given que estou na pagina de login
    Then o campo de usuário está presente
    And o campo de senha está presente

  Scenario: Login com credenciais corretas
    Given que estou na pagina de login
    When eu insiro um nome de usuario e senha corretos
    And eu clico no botao de login
    Then devo ser redirecionado para a página inicial

  Scenario: Login falho por credenciais incorretas
    Given que estou na pagina de login
    When eu insiro um nome de usuário e senha incorretos
    And eu clico no botao de login
    Then an error message "Invalid credentials" is displayed