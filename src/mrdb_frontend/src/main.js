import { createApp } from 'vue';
import App from './App.vue';
import RegisterPage from './components/RegisterPage.vue';
import LoginPage from './components/LoginPage.vue';
import { createWebHistory, createRouter } from "vue-router";

const routes = [
    {path: '/register', component: RegisterPage},
    {path: '/', component: LoginPage}
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

createApp(App).use(router).mount('#app');
