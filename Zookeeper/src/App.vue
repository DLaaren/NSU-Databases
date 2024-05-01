<template>
  <v-app> <!--синоним для <div id="app">-->

    <v-main> <!--контент самого приложения-->

      <v-app-bar
        app
      >
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
        :location="$vuetify.display.mobile ? 'left' : undefined"
        temporary>
        <v-list-item link title="Species" class="text-center"></v-list-item>
        <v-divider></v-divider>
        <v-list-item link title="Animals" class="text-center"></v-list-item>
        <v-divider></v-divider>
        <v-list-item link title="VetCards" class="text-center"></v-list-item>
        <v-divider></v-divider>
        <v-list-item link title="Workers" class="text-center"></v-list-item>
        <v-divider></v-divider>
      </v-navigation-drawer>

      <WelcomePage/>
    </v-main>


  </v-app>
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
  }
</script>
