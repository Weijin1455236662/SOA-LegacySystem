<template>
  <div :class="`${messageType===0?'green':'red'}${messageState?' show':' hide'}${isPC?' tip':' Mobile'}`">
    <i class="icon-font" :class="messageType===0?'i-tick-circle':'i-cross-circle'"></i>
    <div class="text">{{message}}</div>
  </div>
</template>

<script>
    export default {
        name: "MessageTip",
        data(){
            return{
                isPC: true
            }
        },
        props:{
            messageType: {
                type: Number,
                default: 0
            },
            messageState: {
                type: Boolean,
                default: false
            },
            message: {
                type: String,
                default: ''
            }
        },
        mounted() {
            if(sessionStorage.getItem('equipment')==='Mobile'){
                this.isPC = false;
            }
        }
    }
</script>

<style scoped lang="less">
  .tip{
    position: fixed;
    top: 30px;
    left: 48%;
    z-index: 400;
    display: flex;
    border-radius: 4px;
    padding: 10px 20px;
    .icon-font{
      margin-top: 2px;
    }
    .text{
      margin-left: 8px;
    }
  }
  .Mobile{
    position: fixed;
    top: 30px;
    left: 32vw;
    z-index: 400;
    display: flex;
    border-radius: 4px;
    padding: 10px 20px;
    .icon-font{
      margin-top: 2px;
    }
    .text{
      margin-left: 8px;
    }
  }
  .green{
    background-color: #F6FFF6;
    border: 1px solid #008000;
    color: #008000;
  }
  .red{
    background-color: #FFF6F6;
    border: 1px solid #FF0000;
    color: #FF0000;
  }
  .show{
    transform: translateY(0);
    transition: transform 0.5s;
  }
  .hide{
    transform: translateY(-200px);
    transition: transform 0.5s;
  }
</style>