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
  <SideBar :userName = "userName" />

  <div id="movies-container" class="movies-container">
  </div>
  </body>
  </html>
</template>

<script>
import SideBar from "@/components/SideBar";
export default {
  name: 'AdminHomePage',
  components: {SideBar},
  data() {
    return {
      name: '',
      userName: this.$route.params.userName.toString()
    }
  },
  mounted: function() {
    console.log(this.userName);
    //let movies = this.getMovies(userName);
    //console.log(movies);
    /*let movieContainer = document.getElementById("movies-container");
    for(let i = 1;i <= 10; i++) {
      let child = document.createElement('div');
      child.innerHTML = "Movie"+i;
      child.onclick = this.selectMovie;
      child.id = "Movie"+i;
      child.className = "movie";
      movieContainer.appendChild(child);
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
    },
    selectMovie(event) {
      if(event) {
        alert(event.target.id);
      }
    },
    async getMovies(userName) {
      const requestData = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: userName
      };
      const response = await fetch("/api/users/getMovies", requestData);
      const output = await response.text();
      return output;
    }
  }
}
</script>

<style>
:root {
  counter-increment: my-counter 0;
}

html {
  /*background-image: url('../images/background-image.png');*/
  background-color: #7ec699;
  height: 100%;
  width:100%;
  margin: 0;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

body {
  background-color: #7ec699;
  font-family: "Lato", sans-serif;
  margin: 0;
}

.mainNav {
  display: flex;
  flex-direction: row-reverse;
  align-items: center;
  background-color: #2d2d2d;
  width: 100%;
  height: 50px;
}

.nameTag {
  color: #7ec699;
  padding-right: 50px;
}

.movies-container {
  /*position: absolute;*/
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  padding-top: 150px;
  padding-left: 150px;
  text-align: center;
  height: auto;
}

.movie {
  color: #2d2d2d;
  font-weight: bold;
  /*background-color: #2d2d2d;*/
  background-image: url('../images/default-movie-img.png');
  height: 200px;
  width: 200px;
  border-radius: 5px;
  margin: 5px 5px;
}

.movie:hover {
  cursor:pointer;
}

</style>
