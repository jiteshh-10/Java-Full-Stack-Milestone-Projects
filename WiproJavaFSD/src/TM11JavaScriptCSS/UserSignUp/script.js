// This function runs when the entire page is loaded
window.onload = function() {

    // --- 1.1: Live Date and Time Feature ---
    const dateTimeContainer = document.getElementById('datetime-container');

    function updateDateTime() {
        const now = new Date();
        const formattedDate = now.toLocaleDateString(undefined, {
            weekday: 'long', year: 'numeric', month: 'long', day: 'numeric'
        });
        const formattedTime = now.toLocaleTimeString();
        dateTimeContainer.innerHTML = `${formattedDate}, ${formattedTime}`;
    }

    // Update the clock immediately and then every second
    updateDateTime();
    setInterval(updateDateTime, 1000);

    // --- 1.4: 3-Minute Timeout Alert ---
    setTimeout(() => {
        alert("3 mins past. Please submit the form if you haven't already.");
    }, 3 * 60 * 1000); // 3 minutes in milliseconds
};

// --- 1.3: Form Validation Function ---
// This function is called when the form's submit button is clicked
function validateForm() {
    // Helper function to show alerts
    const showAlert = (message) => {
        alert(message);
        return false;
    };

    // Get form field values
    const firstName = document.getElementById('firstName').value.trim();
    const lastName = document.getElementById('lastName').value.trim();
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    const genderMale = document.getElementById('male').checked;
    const genderFemale = document.getElementById('female').checked;
    const mobile = document.getElementById('mobile').value.trim();
    const dob = document.getElementById('dob').value.trim();
    const email = document.getElementById('email').value.trim();

    // Regular Expressions for validation
    const nameRegex = /^[A-Za-z]+$/;
    const mobileRegex = /^(\d{3})([-.\s])(\d{3})\2(\d{4})$/; // Matches XXX-XXX-XXXX, XXX.XXX.XXXX, XXX XXX XXXX
    const dobRegex = /^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\d{4}$/; // DD-MM-YYYY

    // Validation checks
    if (firstName === "") return showAlert("First Name must be entered.");
    if (!nameRegex.test(firstName)) return showAlert("First Name must contain only characters.");

    if (lastName === "") return showAlert("Last Name must be entered.");
    if (!nameRegex.test(lastName)) return showAlert("Last Name must contain only characters.");

    if (password === "") return showAlert("Password must be entered.");
    if (password.length < 6 || password.length > 20) return showAlert("Password length must be between 6 and 20 characters.");

    if (confirmPassword === "") return showAlert("Confirm Password must be entered.");
    if (password !== confirmPassword) return showAlert("Password and Confirm Password must be the same.");

    if (!genderMale && !genderFemale) return showAlert("Gender must be selected.");

    if (mobile === "") return showAlert("Mobile Number must be entered.");
    if (!mobileRegex.test(mobile)) return showAlert("Mobile Number format is invalid. Use XXX-XXX-XXXX, XXX.XXX.XXXX, or XXX XXX XXXX.");

    if (dob === "") return showAlert("Date of Birth must be entered.");
    if (!dobRegex.test(dob)) return showAlert("Date of Birth must be in DD-MM-YYYY format.");

    if (email === "") return showAlert("Email Address must be entered.");
    const atIndex = email.indexOf('@');
    const dotIndex = email.lastIndexOf('.');
    if (atIndex < 1 || dotIndex < atIndex + 2 || dotIndex + 1 >= email.length) {
        return showAlert("Invalid Email Address format.");
    }

    // If all checks pass, allow the form to be submitted
    alert("Registration successful!");
    return true;
}