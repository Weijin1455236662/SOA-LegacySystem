<template>
  <div class="box">
    <div class="wrap" :id="'wrap'+index">
      <div class="standard"></div>
      <div class="load" :id="'load'+index" :style="{'background-color': color}"></div>
      <div class="text" :id="'text'+index">{{(data*100).toFixed(1)}}%</div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "LoadItem",
        data() {
            return{
                computeData: 0,
                color: '#000000',
                colorDic: {
                    '#08ffff' : 0,
                    '#4ea4cb' : 0.2,
                    '#98f20c' : 0.4,
                    '#f59d2a' : 0.6,
                    '#e4c7ff' : 0.8,
                    '#e02e44' : 1
                }
            }
        },
        props: {
            data: {
                type: Number,
                default: 0
            },
            index: {
                type: Number,
                default: 0
            }
        },
        mounted(){
            this.drawLoad();
        },
        methods: {
            drawLoad: function () {
                if(this.data > 1.2){
                    this.computeData = 1.2;
                }else{
                    this.computeData = this.data;
                }
                for (let key in this.colorDic){
                    if(this.data >= this.colorDic[key]){
                        this.color = key;
                    }
                }
                let height = document.getElementById('wrap'+this.index).offsetHeight;
                let loadTop = height * (1.2 - this.computeData) / 1.2;
                document.getElementById('load'+this.index).style.top = loadTop + 'px';
                let textHeight = document.getElementById('text'+this.index).offsetHeight;
                if (height - loadTop < textHeight){
                    document.getElementById('text'+this.index).style.top = height - textHeight + 'px';
                }else{
                    document.getElementById('text'+this.index).style.top = (height + loadTop - textHeight)/2 + 'px';
                }
            }
        },
        watch: {
            'data': function () {
                this.drawLoad();
            }
        }
    }
</script>

<style scoped lang="less">
  .box{
    border: 2px solid #e0e0e0;
    margin: 0 10%;
    width: 80%;
    height: 100%;
    border-radius: 6px;
    .wrap{
      width: 100%;
      height: 100%;
      position: relative;
      .standard{
        height: 16.66666%;
        border-bottom: 1px dashed #e0e0e0;
      }
      .load{
        position: absolute;
        width: 100%;
        bottom: 0;
        left: 0;
        border-radius: 4px;
      }
      .text{
        position: absolute;
        width: 100%;
        text-align: center;
        top: 0;
        left: 0;
      }
    }
  }
</style>