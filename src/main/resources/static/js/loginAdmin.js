document.addEventListener("DOMContentLoaded", function() {
    var togglePassword = document.querySelector(".toggle-password");
    var passwordInput = document.getElementById("password");

    togglePassword.addEventListener("click", function() {
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
        } else {
            passwordInput.type = "password";
        }
    });
});
