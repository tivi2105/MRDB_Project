<template>
  <router-view :creds="creds"></router-view>
</template>

<script>

export default {
  name: 'App',
  components: {},
  props: {userName: String, password: String},
  data() {
    return {
      creds: {username: this.userName, password: this.password}
    }
  }
}
</script>

<style>
</style>

