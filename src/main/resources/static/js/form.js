

    let selectElement = document.getElementById("registeredUsers");
    let emailInputElement = document.getElementById("email");

    selectElement.addEventListener('change', function() {
        let selectedEmail = selectElement.value;
        emailInputElement.value = selectedEmail;
    });
