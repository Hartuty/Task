<template>
<div class="card">

<div class="card-header">
    Add Users
  </div>
<div class="col">
  <form enctype="multipart/form-data">

  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name</label>
    <input type="text" class="form-control" name="name" v-model="fields.name" >
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Department</label>
    <input type="Text" class="form-control" id="exampleInputPassword1" name="department" v-model="fields.department">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Image</label>
    <input type="file" id="file" name="file" class="form-control" ref="file" v-on:change="handleFileUpload()"/>
  </div>
  <button v-on:click="submit()" class="btn btn-primary">Add</button>
</form>
</div>
</div>
</template>

<script>
    export default {
        data(){
            return {
                fields: {},
                file: ''
            }
        },
        methods: {
            submit() {
                let formData = new FormData();
                
                formData.append('file',this.file);
                formData.append('name',this.fields.name);
                formData.append('department',this.fields.department);
                axios.post('/store',formData).then(response=>{
                    this.fields={};
                }).catch(error=>{
                    console.log('Error');
                });
            },
            handleFileUpload(){
                this.file = this.$refs.file.files[0];
            }
        }
    }
</script>