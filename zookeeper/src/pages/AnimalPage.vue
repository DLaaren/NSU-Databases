<template>
    <v-card>
        <v-tabs
            v-model="tab"
            fixed-tabs
        >
        
            <v-tab value="all">All Animals</v-tab>
            <v-tab value="find">Find Animal</v-tab>
            <v-tab value="add">Add Animal</v-tab>
            
        </v-tabs>
  
        <v-tabs-window v-model="tab">
            <v-tabs-window-item value="find">
                <AnimalFind/>
            </v-tabs-window-item>

            <v-tabs-window-item value="add">
                <AnimalAdd/>
            </v-tabs-window-item>

            <v-tabs-window-item value="all">
                <AnimalsDataTable/>
            </v-tabs-window-item>
        </v-tabs-window>

    </v-card>
  </template>


<script>
export default {
    data: () => ({
        tab: null,
    }),

}
</script>