const submit_button = document.querySelector(".button");
submit_button.onclick = (e) => {
    e.preventDefault();
    const fname = document.getElementById("fname").value;
    const lname = document.getElementById("lname").value;
    const email = document.getElementById("email").value;
    const pass = document.getElementById("pass").value;
    const cpass = document.getElementById("cpass").value;

    localStorage.setItem('FirstName', fname);
    localStorage.setItem('LastName', lname);
    localStorage.setItem('Email', email);
    localStorage.setItem('Password', pass);
    localStorage.setItem('Cpassword', cpass);
    if ((fname == "George" && lname == "Bluth" && email == "george.bluth@reqres.in") || (fname == "Janet" && lname == "Weaver" && email == "janet.weaver@reqres.in") || (fname == "Emma" && lname == "Wong" && email == "emma.wong@reqres.in") || (fname == "Eve" && lname == "Holt" && email == "eve.holt@reqres.in") ||
    (fname == "Charles" && lname == "Morris" && email == "charles.morris@reqres.in") || (fname == "Tracy" && lname == "Ramos" && email == "tracey.ramos@reqres.in")) {
       alert("sucessful");
    } else {
       alert("unsucessful");
    }
    
    if(fname == "" && lname == "" && email == "" && pass == "" && cpass == ""){
        Swal.fire(
            'Opps..!',
            'input field has no value!',
            'error'
        );
    }
    else
    {
        if(pass.length >= 6 && pass.length <= 20)
    {
        if( pass !== cpass){
            Swal.fire(
                'Opps..!',
                'Password not matching!',
                'error'
            );
        }
        else
        {
            Swal.fire(
                'Good job!',
                'Register successful!',
                'success'
            );
            setTimeout(()=>{
                    location.href='login.html';
                    },5000)
        }
    }
    else
    {
        Swal.fire(
            'Opps..!',
            'Input mim six digit password!',
            'error'
        );
    }
    }


}

const login = document.querySelector('.login');
login.onclick = (e) => {
    e.preventDefault();
    // cautch the valu which is type user login page
    const emailAddress = document.getElementById("emailAddress").value;
    const passWord = document.getElementById("passWord").value;


    // let's get value in localstorage which store user in registration field
    const Email = localStorage.getItem("Email");
    const Password = localStorage.getItem("Password");

    if( emailAddress == "" && passWord == ""){
        Swal.fire(
            'Opps..!',
            'input field has no value!',
            'error'
        );
    }
    else
    {
        if(emailAddress == Email && passWord == Password){
            Swal.fire(
                'Good job!',
                'login successful!',
                'success'
            );
            setTimeout(()=>{
                location.href='hp.html';
                },1000)
        }else
        {
            Swal.fire(
                'Opps..!',
                'Something is wrong!',
                'error'
            );
        }
    };


};