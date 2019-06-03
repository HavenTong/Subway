<template>
    <h1>Hello World</h1>
</template>



<script>
import {postRequest} from '../utils/api'
import {putRequest} from '../utils/api'
export default {
    methods:{
        test:function(){
            alert("Success");
        }
    },
    data() {
        return {
            status: "success"
        }
    }
}
</script>
