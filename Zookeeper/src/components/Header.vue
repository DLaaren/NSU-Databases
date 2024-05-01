<template>
    <v-app-bar>
        <v-app-bar-nav-icon
          variant="text"
          @click.stop="drawer = !drawer">
        </v-app-bar-nav-icon>

        <v-app-bar-title>
          <h3>Zookeeper</h3>
        </v-app-bar-title>
    </v-app-bar>

    <v-navigation-drawer
        v-model="drawer"
        temporary>
        <v-list-item link title="Main" class="text-center" @click="goToMainPage"></v-list-item>
        <v-divider></v-divider>
        <v-list-item link title="Species" class="text-center" @click="goToSpeciesPage"></v-list-item>
        <v-divider></v-divider>
        <v-list-item link title="Animals" class="text-center" @click="goToAnimalsPage"></v-list-item>
        <v-divider></v-divider>
        <v-list-item link title="Workers" class="text-center" @click="goToWorkersPage"></v-list-item>
        <v-divider></v-divider>
    </v-navigation-drawer>

</template>

<script>
export default {

    data: () => ({
      drawer: false,
      group: null,
    }),

    watch: {
      group() {
        this.drawer = false
      },
    },
    
    methods: {
      goToMainPage() {
        this.$router.push('/')
      },
      goToSpeciesPage() {
        this.$router.push('/species/all')
      },
      goToAnimalsPage() {
        this.$router.push('/animal/all')
      },
      goToWorkersPage() {
        this.$router.push('/worker/all')
      },
    }
  }
</script>