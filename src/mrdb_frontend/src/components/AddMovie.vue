<template>
  <!DOCTYPE html>
  <html lang="en">
  <head>
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>MRDB Application</title>
  </head>
  <body>
  <div id="mainNav" class="mainNav">
    <p class="nameTag">{{ $route.params.userName }}</p>
  </div>
  <SideBar />
  <div id="movies-container" class="movies-container">
    <table id="movies-table" class="movies-table">
      <tr>
        <th>Movie1</th>
        <th>Movie2</th>
        <th>Movie3</th>
      </tr>
      <tr>
        <th>Movie4</th>
        <th>Movie5</th>
        <th>Movie6</th>
      </tr>
      <tr>
        <th>Movie7</th>
        <th>Movie8</th>
        <th>Movie9</th>
      </tr>
    </table>
  </div>
  </body>
  </html>
</template>

<script>
import SideBar from "@/components/SideBar";
export default {
  name: "AddMovie",
  components: {SideBar},
  data() {
    return {
      name: ''
    }
  },
  mounted: function() {
    console.log(this.$route.params.userName);
    /*if(!this.fields.userName || !this.fields.password) {
      window.location.href = '/';
    }*/
  },
  methods: {
    closeNav() {
      document.getElementById("sideNav").style.width = "0";
    },
    openNav() {
      document.getElementById("sideNav").style.width = "250px";
    },
    toDashBoard() {
      alert('test');
    },
    logout() {
      window.location.href = '/';
    }
  }
}
</script>

<style scoped>

</style>