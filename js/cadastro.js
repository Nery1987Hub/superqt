const API_BASE = "http://localhost:8080/aluno";
 
const formCadastro = document.getElementById("form-cadastro");

async function request(path = "", options = {}) {
  const headers = {
    ...(options.headers || {})
  };
 
  if (options.body && !headers["Content-Type"] && !headers["content-type"]) {
    headers["Content-Type"] = "application/json";
  }
 
  const fetchOptions = {
    ...options,
    ...(Object.keys(headers).length > 0 ? { headers } : {})
  };
 
  const resposta = await fetch(`${API_BASE}${path}`, fetchOptions);
 
  let conteudo;
  const tipo = resposta.headers.get("content-type") || "";
 
  if (tipo.includes("application/json")) {
    conteudo = await resposta.json();
  } else {
    conteudo = await resposta.text();
  }
 
  if (!resposta.ok) {
    const mensagem =
      (conteudo && conteudo.message) ||
      (typeof conteudo === "string" && conteudo) ||
      "Falha na requisicao.";
    throw new Error(mensagem);
  }
 
  return conteudo;
}
 
async function cadastrarAluno(event) {
  event.preventDefault();
 
  const dados = new FormData(formCadastro);
  const payload = {
    senha: dados.get("senha"),
    cpfaluno: dados.get("cpfaluno"),
    idade: dados.get("idade")
  };
 
  try {
    const alunoCriado = await request("", {
      method: "POST",
      body: JSON.stringify(payload)
    });

    formCadastro.reset();

  } catch (erro) {
    // setStatus("Falha ao cadastrar aluno.", "error");
    // setSaida({ erro: erro.message, enviado: payload });
  }
}

if (formCadastro) {
  formCadastro.addEventListener("submit", cadastrarAluno);
}
