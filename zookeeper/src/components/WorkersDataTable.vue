<template>
    <v-container>
        <v-responsive
        class="align-centerfill-height mx-auto"
        max-width="1500"
        >
            <h2 class="text-left text-h3 font-weight-bold">Workers</h2>
            <br>

            <v-data-table
            v-model:items-per-page="itemsPerPage"
            :headers="headers"
            :items="workers" item-value="id"
            class="elevation-1">
            </v-data-table>
            
        </v-responsive>
    </v-container>
</template>

<script>
export default {
    name: 'DataTable',
    data: () => ({
        itemsPerPage: 10,
        headers: [
            {
                title: 'Worker ID',
                align: 'center',
                key: 'id'
            },
            { title: 'Name', align: 'center', key: 'name' },
            { title: 'Age', align: 'center', key: 'age' },
            { title: 'Salary', align: 'center', key: 'salary' },
            { title: 'Job Title', align: 'center', key: 'jobTitle' },
        ],
    }),
    methods: {
      async getData() {
        try {
          const response = await fetch(
            'http://localhost:8080/api/v1/worker/all', { method: 'GET' });
          this.workers = await response.json();
        } catch (error) {
          console.error(error);
        }
      },
    },
    created() {
      this.getData()
    },
}
</script>