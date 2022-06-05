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
    <div class="main">
        <p class="sign" align="center">Sign in</p>
        <form class="form1" @submit="validate">
            <input v-model="fields.userName" class="un" type="text" align="center" placeholder="Username">
            <input v-model="fields.password" class="pass" type="password" align="center" placeholder="Password">
            <input class="submit" type="submit" >
            <p class="forgot"><a href="#">Forgot Password?</a></p>
            <p class="forgot"><router-link to="/register">New User? Register Here</router-link></p>
        </form>
    </div>
  </body>
</template>

<script>

export default {
  name: 'LoginPage',
  data() {
    return {
      msg: '',
      fields: {userName: '', password: ''},
      testField: ''
    }
  },
  methods: {
    async validate(e) {
      e.preventDefault();
        if(!this.fields.userName) {
            alert("Please enter a valid user name");
            return false;
        }
        if(!this.fields.password) {
          alert("Please enter a valid password");
            return false;
        }
        let data = JSON.stringify(this.fields);
        console.log(data);
        await this.login(data);
    },
    async login(data) {
        const requestData = {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: data
        };
        const response = await fetch("/api/users/login", requestData);
        const output = await response.text();
        if(output === 'Success') {
            alert('Login successful');
            window.location.href = '/admin/'+this.fields.userName;
        } else {
            alert('Username or password is wrong');
        }
    }
  }
}
</script>

<style>
body {
background-color: #F3EBF6;
    font-family: 'Ubuntu', sans-serif;
}

.main {
    background-color: #FFFFFF;
    width: 400px;
    height: 400px;
    margin: 7em auto;
    border-radius: 1.5em;
    box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
}

.sign {
    padding-top: 30px;
    color: #8C55AA;
    font-family: 'Ubuntu', sans-serif;
    font-weight: bold;
    font-size: 23px;
}



    .un {
    width: 76%;
    color: rgb(38, 50, 56);
    font-weight: 700;
    font-size: 14px;
    letter-spacing: 1px;
    background: rgba(136, 126, 126, 0.04);
    padding: 10px 20px;
    border-radius: 20px;
    outline: none;
    box-sizing: border-box;
    border: 2px solid rgba(0, 0, 0, 0.02);
    margin-left: 46px;
    text-align: center;
    margin-bottom: 27px;
    font-family: 'Ubuntu', sans-serif;
    }

    form.form1 {
        padding-top: 40px;
    }

    .pass {
            width: 76%;
    color: rgb(38, 50, 56);
    font-weight: 700;
    font-size: 14px;
    letter-spacing: 1px;
    background: rgba(136, 126, 126, 0.04);
    padding: 10px 20px;
    border-radius: 20px;
    outline: none;
    box-sizing: border-box;
    border: 2px solid rgba(0, 0, 0, 0.02);
    margin-left: 46px;
    text-align: center;
    margin-bottom: 27px;
    font-family: 'Ubuntu', sans-serif;
    }


    .un:focus, .pass:focus {
        border: 2px solid rgba(0, 0, 0, 0.18) !important;

    }

    .submit {
      cursor: pointer;
        border-radius: 5em;
        color: #fff;
        background: linear-gradient(to right, #9c27b0, #E040FB);
        border: 0;
      padding: 10px 40px;
      font-family: 'Ubuntu', sans-serif;
        margin-left: 35%;
        font-size: 13px;
        box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
    }

    .forgot {
        text-shadow: 0 0 3px rgba(117, 117, 117, 0.12);
        color: #8C55AA;
        padding-top: 15px;
    }

    a {
        text-shadow: 0 0 3px rgba(117, 117, 117, 0.12);
        color: purple;
        text-decoration: none
    }

    @media (max-width: 600px) {
        .main {
            border-radius: 0;
        }
    }
</style>
