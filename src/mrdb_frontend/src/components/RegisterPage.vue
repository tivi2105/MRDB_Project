<template>
  <!DOCTYPE html>
  <html lang="en">
      <head>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
        <meta charset="UTF-8">
        <title>MRDB Application</title>
      </head>
  <body>
    <div class="reg-main">
        <p class="sign" align="center">Register</p>
        <form class="form1" @submit="validate">
            <input v-model="fields.firstName" class="un" type="text" align="center" placeholder="First Name">
            <input v-model="fields.lastName" class="un" type="text" align="center" placeholder="Last Name">
            <input v-model="fields.email" class="un" type="text" align="center" placeholder="Email">
            <input v-model="fields.phone" class="un" type="text" align="center" placeholder="Phone">
            <input v-model="fields.userName" class="un" type="text" align="center" placeholder="UserName">
            <input v-model="fields.password" class="pass" type="password" align="center" placeholder="Password">
            <!--<input id="confirmPassword" class="pass" type="password" align="center" placeholder="Confirm Password">-->
            <select v-model="fields.userType" class="un" placeholder="Select">
              <option class="un">Admin</option>
              <option class="un">User</option>
            </select>
            <input class="submit" align="center" type="submit" >
            <p class="forgot" align="center"><router-link to="/">Existing User? Sign in</router-link></p>
        </form>
    </div>
  </body>
  </html>
</template>

<script>
export default {
  name: 'RegisterPage',
  data() {
    return {
      msg: '',
      errors: [],
      fields: {firstName: '', lastName: '', email: '', phone: '', userName: '', password: '', userType: ''}
    }
  },
  methods: {
    async validate(e) {
        if(!this.fields.firstName) {
            alert("Please enter first name");
            e.preventDefault();
            return;
        }
        if(!this.fields.lastName) {
            alert("Please enter last name");
            e.preventDefault();
            return;
        }
        if(!(await this.validEmail(this.fields.email))) {
            alert("Please enter a valid email");
            e.preventDefault();
            return;
        }
        if(!this.fields.phone || this.fields.phone.length === 0) {
            alert("Please enter a valid Phone number");
            e.preventDefault();
            return;
        }
        if(!this.fields.userName) {
            alert("Please enter a valid user name");
            return;
        }
        if(!this.fields.password) {
            alert("Please enter a valid password");
            return;
        }
        if(!this.fields.userType) {
          alert("Please select userType");
          return;
        }
        let data = JSON.stringify(this.fields);
        await this.saveDetails(data);
        e.preventDefault();
    },
    async validEmail(email) {
        let re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    },
    async saveDetails(data) {
        const requestData = {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: data
        };
        const response = await fetch("/api/users/register", requestData);
        const output = await response.text();
        if(output === 'problem') {
            alert('Oops.. there seems to be a problem, please try again');
        } else if(output === 'Success') {
            alert('User created');
            window.location.href = '/';
        } else {
            alert(output);
        }
    }
  }
}
</script>

<style>

.reg-main {
    background-color: #FFFFFF;
    width: 400px;
    height: 700px;
    margin: 1em auto;
    border-radius: 1.5em;
    box-shadow: 0 11px 35px 2px rgba(0, 0, 0, 0.14);
}
</style>
