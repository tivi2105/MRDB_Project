<template>
  <!DOCTYPE html>
  <html lang="en">
      <head>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
        <meta charset="UTF-8">
        <title>MRDB Application</title>
      </head>
  </html>
  <body>
    <div class="reg-main">
        <p class="sign" align="center">Register</p>
        <form class="form1">
            <input id="firstName" class="un" type="text" align="center" placeholder="First Name">
            <input id="lastName" class="un" type="text" align="center" placeholder="Last Name">
            <input id="email" class="un" type="text" align="center" placeholder="Email">
            <input id="phone" class="un" type="text" align="center" placeholder="Phone">
            <input id="userName" class="un" type="text" align="center" placeholder="UserName">
            <input id="password" class="pass" type="password" align="center" placeholder="Password">
            <!--<input id="confirmPassword" class="pass" type="password" align="center" placeholder="Confirm Password">-->
            <a class="submit" align="center" v-on:click="saveDetails">Register</a>
            <p class="forgot" align="center"><a href="/">Existing User? Sign in</a></p>
        </form>
    </div>
  </body>
</template>

<script>
export default {
  name: 'RegisterPage',
  data() {
    return {
      msg: ''
    }
  },
  methods: {
    async saveDetails() {
        const data = {firstName: document.getElementById('firstName').value,
                    lastName: document.getElementById('lastName').value,
                    email: document.getElementById('email').value,
                    phone: document.getElementById('phone').value,
                    userName: document.getElementById('userName').value,
                    password: document.getElementById('password').value
                    }
        const requestData = {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(data)
        };
        const response = await fetch("/api/users/register", requestData);
        const output = await response.text();
        if(output === 'Ok') {
            alert('User Created');
            window.location.href = '/';
        } else {
            alert('problem');
        }
    }
  }
}
</script>

<style>

    .reg-main {
        background-color: #FFFFFF;
        width: 400px;
        height: 610px;
        margin: 5em auto;
        border-radius: 1.5em;
        box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
    }
</style>
