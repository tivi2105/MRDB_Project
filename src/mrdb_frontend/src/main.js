import { createApp } from 'vue';
import App from './App.vue';
import RegisterPage from './components/RegisterPage.vue';
import LoginPage from './components/LoginPage.vue';
import AdminDashBoard from './components/AdminDashBoard.vue';
import AddMovie from './components/AddMovie.vue';
import { createWebHistory, createRouter } from "vue-router";

const routes = [
    {path: '/register', component: RegisterPage, name: 'RegisterPage'},
    {path: '/', component: LoginPage, name: 'LoginPage'},
    {path: '/admin', component: AdminDashBoard, name: 'AdminDashBoard'},
    {path: '/admin/:userName', component: AdminDashBoard, name: 'AdminDashBoard'},
    {path: '/add-movie/:userName', component: AddMovie, name: 'AddMovie'}
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

createApp(App).use(router).mount('#app');
