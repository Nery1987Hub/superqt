document.addEventListener("DOMContentLoaded", () => {
    const acessibBtn = document.getElementById("acessib-toggle-btn");
    const dropAcessibBox = document.getElementById("dropAcessib-box");

    acessibBtn.addEventListener("click", (event) => {
        event.stopPropagation(); 
        
        dropAcessibBox.classList.toggle("hidden");
    });

    dropAcessibBox.addEventListener("click", (event) => {
        event.stopPropagation();
    });

    document.addEventListener("click", () => {
        dropAcessibBox.classList.add("hidden");
    });
});