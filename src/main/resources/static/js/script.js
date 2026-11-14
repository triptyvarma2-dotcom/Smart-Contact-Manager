

const validations = {
    name: value =>
        value.trim().length > 0 &&
        value.length >= 2 &&
        value.length <= 20,

    email: value =>
        /^[a-zA-Z0-9_,%*+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(value),

    password: value =>
        /^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[^0-9A-Za-z]).{8,32}$/.test(value),

    about: value =>
        value.trim().length > 0 &&
        value.length >= 10 &&
        value.length <= 500
};

Object.entries(validations).forEach(([name, isValid]) => {

    const field = document.querySelector(`[name="${name}"]`);

    if (!field) return;

    field.addEventListener("input", function () {

        if (isValid(field.value)) {

            field.classList.remove("is-invalid");

            const errors = field.parentElement.querySelectorAll(".invalid-feedback");

            errors.forEach(error => {
                error.style.display = "none";
            });
        }
    });
});

