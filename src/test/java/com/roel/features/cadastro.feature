
Feature: Formulário de Cadastro



Scenario: Verificar se os campos de entrada estão presentes
  Given que estou na página de cadastro
  Then os seguintes campos devem estar presentes:
  | Campo  |
  | Nome   |
  | Email  |
  | CPF    |
  | Senha  |

Scenario: : Cadastro com dados válidos
  Given que estou na página de cadastro
  When preencho todos os campos com dados válidos
  And clico no botão "Cadastrar"
  Then o cadastro é realizado com sucesso
  And sou redirecionado para a página inicial

Scenario: Cadastro com email inválido
  Given que estou na página de cadastro
  When preencho o campo "Email" com "email_invalido"
  And preencho os demais campos com dados válidos
  And clico no botão "Cadastrar"
  Then uma mensagem de erro é exibida informando "Email inválido"

Scenario: Cadastro com CPF inválido
  Given iven que estou na página de cadastro
  When preencho o campo "CPF" com "123.456.789"
  And preencho os demais campos com dados válidos
  And clico no botão "Cadastrar"
  Then uma mensagem de erro é exibida informando "CPF inválido"

Scenario: Cadastro com senha fraca
  Given que estou na página de cadastro
  When preencho o campo "Senha" com "123"
  And preencho os demais campos com dados válidos
  And clico no botão "Cadastrar"
  Then uma mensagem de erro é exibida informando "A senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas e números"

Scenario: Cadastro com campos obrigatórios em branco
  Given que estou na página de cadastro
  When deixo todos os campos em branco
  And clico no botão "Cadastrar"
  Then mensagens de erro são exibidas informando que os campos são obrigatórios

Scenario: Cadastro com email já existente
  Given que estou na página de cadastro
  And já existe um usuário cadastrado com o email "joao.silva@example.com"
  When preencho o campo "Email" com "joao.silva@example.com"
  And preencho os demais campos com dados válidos
  And clico no botão "Cadastrar"
  Then uma mensagem de erro é exibida informando "Email já cadastrado"

Scenario: Cadastro com CPF já existente
  Given que estou na página de cadastro
  And já existe um usuário cadastrado com o CPF "123.456.789-00"
  When preencho o campo "CPF" com "123.456.789-00"
  And preencho os demais campos com dados válidos
  And clico no botão "Cadastrar"
  Then uma mensagem de erro é exibida informando "CPF já cadastrado"




