// Função para Alternar o Tema (Claro / Escuro)
function alternarTema() {
    const elementoHtml = document.documentElement;
    const botaoTema = document.getElementById('btn-tema');
    
    // Verifica o tema atual ativo
    const temaAtual = elementoHtml.getAttribute('data-theme');
    
    if (temaAtual === 'dark') {
        elementoHtml.removeAttribute('data-theme'); // Volta para o padrão (claro)
        botaoTema.innerHTML = 'Modo Escuro 🌙';
        localStorage.setItem('tema-selecionado', 'light');
    } else {
        elementoHtml.setAttribute('data-theme', 'dark'); // Ativa modo escuro
        botaoTema.innerHTML = 'Modo Claro ☀️';
        localStorage.setItem('tema-selecionado', 'dark');
    }
}

// Carrega as preferências salvas assim que a página abre
document.addEventListener('DOMContentLoaded', () => {
    const temaSalvo = localStorage.getItem('tema-selecionado');
    const botaoTema = document.getElementById('btn-tema');
    
    if (temaSalvo === 'dark') {
        document.documentElement.setAttribute('data-theme', 'dark');
        if (botaoTema) botaoTema.innerHTML = 'Modo Claro ☀️';
    }
});
