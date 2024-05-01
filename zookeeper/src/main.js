/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Plugins
import { registerPlugins } from '@/plugins'

// Components
import App from './App.vue'
import WelcomePage from './pages/WelcomePage.vue'
import AnimalPage from './pages/AnimalPage.vue'
import SpeciesPage from './pages/SpeciesPage.vue'
import WorkerPage from './pages/WorkerPage.vue'

import { createRouter, createWebHashHistory } from 'vue-router'

// Composables
import { createApp } from 'vue'

const routes = [
    { 
        path: '/', 
        name: 'Welcome', 
        component: WelcomePage 
    },
    { 
        path: '/animal', 
        name: 'Animals', 
        component: AnimalPage 
    },
    // {
    //     path: '/animal/:id', 
    //     name: 'Animal', 
    //     component: AnimalPage 
    // },
    { 
        path: '/species', 
        name: 'Species', 
        component: SpeciesPage 
    },
    { 
        path: '/worker', 
        name: 'Workers', 
        component: WorkerPage 
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes,
})


const app = createApp(App)

app.use(router)

registerPlugins(app)

app.mount('#app')
