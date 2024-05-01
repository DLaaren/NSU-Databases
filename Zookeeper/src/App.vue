<template>
  <v-app> <!--синоним для <div id="app">-->

    <v-main> <!--контент самого приложения-->
      <Header/>
      <v-fade-transition appear hide-on-leave="true">
        <RouterView/>
      </v-fade-transition>
    </v-main>

  </v-app>
</template>

<script>
</script>
