<template>
  <div id="sideNav" class="sideNav">
    <a href="javascript:void(0)" class="closebtn" v-on:click="closeNav">&times;</a>
    <table>
      <tr>
        <th><router-link :to="{name: 'AdminDashBoard', param: 'userName'}">Dashboard</router-link></th>
      </tr>
      <tr>
        <th><router-link :to="{name: 'AddMovie', param: 'userName'}">Add Movies</router-link></th>
      </tr>
      <tr>
        <th><router-link :to="{name: 'AdminDashBoard', param: 'userName'}">Remove Movies</router-link></th>
      </tr>
      <tr>
        <th><router-link :to="{name: 'AdminDashBoard'}">Add Users</router-link></th>
      </tr>
      <tr>
        <th><router-link :to="{name: 'AdminDashBoard'}">Remove Users</router-link></th>
      </tr>
    </table>
    <router-link class="logout" to="/">Logout</router-link>
  </div>
  <span class="sideNavButton" v-on:click="openNav" >&#9776;</span>
</template>

<script>
export default {
  name: "SideBar",
  props: {userName : String},
  methods: {
    closeNav() {
      document.getElementById("sideNav").style.width = "0";
    },
    openNav() {
      document.getElementById("sideNav").style.width = "250px";
    },
    logout() {
      window.location.href = '/';
    }
  }
}
</script>

<style scoped>
.sideNav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sideNav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.5s;
}

.sideNav p {
  position: absolute;
  top: 0;
  left: 10px;
  /*padding: 8px 8px 8px 32px;*/
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.5s;
}
.sideNav p {
  position: absolute;
  top: 0;
  left: 10px;
  /*padding: 8px 8px 8px 32px;*/
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.5s;
}

.sideNav table{
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.5s;
}

.sideNav th {
  padding-bottom: 1em;
}

.sideNav router-link {
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.5s;
  outline:none;
  background-color: transparent;
  background-repeat: no-repeat;
  border: none;
  width: 100%;
}

.sideNav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}


.sideNav .logout {
  position: absolute;
  top: 600px;
  /*margin-left: 50px;*/
}

.sideNav button:hover{
  cursor:pointer;
}

.sideNav a:hover {
  color: #f1f1f1;
}

.sideNav p:hover {
  color: #f1f1f1;
}

.sideNavButton {
  position: absolute;
  width: 50px;
  height: 50px;
  top: 0;
  left: 0;
  font-size:30px;
  cursor:pointer;
  background-color: #2d2d2d;
  color: #7ec699;
  text-align: center;
}
</style>