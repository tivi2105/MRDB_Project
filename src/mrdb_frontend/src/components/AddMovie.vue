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
  <h1>Add New Movie</h1>
  <div id="movie-details" class="movie-details">
    <form class="form1" @submit="validate">
      <input v-model="fields.movieName" class="textClass" type="text" placeholder="Movie Title" style="font-size: 20px">
      <textarea v-model="fields.movieDesc" class="textClass" placeholder="Movie Description" rows="10"></textarea>
      <input v-model="fields.genre" class="textClass" type="text" placeholder="Movie Genre" style="font-size: 20px">
      <h3>Cast</h3>
      <div v-for="(input, index) in movieCast" :key="`movieCastInput-${index}`" class="movieCast" ref="movieCast" id = "movieCast">
        <p><select v-model="input.title" style="width: 20%" placeholder="Title">
          <option>directors</option>
          <option>Assistant Directors</option>
          <option>starring</option>
        </select></p>
        <p><input v-model="input.name" style="width: 20%" placeholder="Name"></p>
        <p>
          <svg

              @click="addNewCast(input, movieCast)"
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 24 24"
              width="24"
              height="24"
              class="addCast"
          >
            <path fill="none" d="M0 0h24v24H0z" />
            <path
                fill="green"
                d="M11 11V7h2v4h4v2h-4v4h-2v-4H7v-2h4zm1 11C6.477 22 2 17.523 2 12S6.477 2 12 2s10 4.477 10 10-4.477 10-10 10zm0-2a8 8 0 1 0 0-16 8 8 0 0 0 0 16z"
            />
          </svg>
          <svg
              v-show="movieCast.length > 1"
              @click="removeCast(index, movieCast)"
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 24 24"
              width="24"
              height="24"
              class="addCast"
          >
            <path fill="none" d="M0 0h24v24H0z" />
            <path
                fill="#EC4899"
                d="M12 22C6.477 22 2 17.523 2 12S6.477 2 12 2s10 4.477 10 10-4.477 10-10 10zm0-2a8 8 0 1 0 0-16 8 8 0 0 0 0 16zm0-9.414l2.828-2.829 1.415 1.415L13.414 12l2.829 2.828-1.415 1.415L12 13.414l-2.828 2.829-1.415-1.415L10.586 12 7.757 9.172l1.415-1.415L12 10.586z"
            />
          </svg>
          <!--<label class="addMovie" @click="addNew(input, movieCast)" style="padding: 10px 12px;">+</label>
          <label class="addMovie" @click="addNew(input, movieCast)" style="padding: 10px 12px;">-</label>-->
        </p>
      </div>
      <input class="addMovie" type="submit" value="Add Movie">
    </form>
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
      name: '',
      fields: {movieName: '', movieDesc: '', genre: ''},
      movieCast: [{title: "", name: ""}]
    }
  },
  mounted: function() {
    console.log(this.$route.params.userName);
    /*if(!this.fields.userName || !this.fields.password) {
      window.location.href = '/';
    }*/
  },
  methods: {
    async validate(e) {
      e.preventDefault();
      let movieCast = this.movieCast;
      for(let i = 0;i < movieCast.length; i++) {
        console.log(movieCast[i].title+'--'+movieCast[i].name);
      }
      alert('Test');
      let userName = this.$route.params.userName;
      let data = this.fields;
      data['userName'] = userName;
      let apiMovieData = JSON.stringify(this.fields);

      let movieCastData = {};
      movieCastData['movieName'] = this.fields.movieName;
      for(let i = 0;i < movieCast.length; i++) {
        if(undefined === movieCastData[movieCast[i].title]) {
          movieCastData[movieCast[i].title] = movieCast[i].name;
        } else {
          movieCastData[movieCast[i].title] = movieCastData[movieCast[i].title] + ',' + movieCast[i].name;
        }
      }
      movieCastData = JSON.stringify(movieCastData);

      let movieRes = await this.saveMovieToDb(apiMovieData);
      let movieCastRes = await this.saveMovieCastToDb(movieCastData);

      if(movieRes === "Success" && movieCastRes === "Success") {
        alert('Movie added successfully');
      } else {
        alert('Error occurred, try again after sometime');
      }
    },
    addNewCast(value, fieldType) {
      fieldType.push({ title: "", name: "" });
    },
    removeCast(index, fieldType) {
      fieldType.splice(index, 1);
    },
    async saveMovieToDb(data) {
      const requestData = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: data
      };
      const response = await fetch("/api/users/saveMovie", requestData);
      const output = await response.text();
      if(output === 'Success') {
        return "Success";
      }
      return "Fail";
    },
    async saveMovieCastToDb(data) {
      const requestData = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: data
      };
      const response = await fetch("/api/users/saveMovieCast", requestData);
      const output = await response.text();
      if(output === 'Success') {
        return "Success";
      }
      return "Fail";
    }
  }
}
</script>

<style scoped>
.textClass {
  width: 50%;
  color: rgb(38, 50, 56);
  font-weight: 700;
  font-size: 14px;
  letter-spacing: 1px;
  background: rgba(136, 126, 126, 0.5);
  padding: 10px 20px;
  border-radius: 20px;
  outline: none;
  box-sizing: border-box;
  border: 2px solid rgba(0, 0, 0, 0.2);
  margin-left: 46px;
  text-align: center;
  margin-bottom: 27px;
  font-family: 'Ubuntu', sans-serif;
}
.form1 {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.addMovie {
  cursor: pointer;
  border-radius: 5em;
  color: #fff;
  background: linear-gradient(to right, #9c27b0, #E040FB);
  border: 0;
  padding: 10px 20px;
  font-family: 'Ubuntu', sans-serif;
  font-size: 13px;
  box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
}

.movieCast {
  display: flex;
  flex-wrap: wrap;
  width: 50%;
  text-align: center;
}
.movieCast * {
  width: 33%;
}

.addCast {
  cursor: pointer;
  width: 20%;
  padding: 2px;
}
</style>