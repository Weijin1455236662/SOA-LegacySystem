<template>
  <div :class="isPC?'main':'mobile'">
    <message-tip :message-state="messageState" :message-type="messageType" :message="message"></message-tip>
    <div class="head">
      <div class="text">订单-生产单关系表</div>
      <hr/>
    </div>
    <div class="container">
      <div class="table">
        <div class="row">
          <div class="column index0">订单号码</div>
          <div class="column index1">生产单号</div>
        </div>
        <div class="row" v-for="(order, index) in allOrder" :key="index">
          <div class="column index0">
            <div class="order" :title="'前往订单'+ order.orderid + '计划图'" @click="nav(order.orderid)">
              <span class="id">{{(order.orderid)}}</span>：需要{{order.quantity}}个物料{{order.material_code}}
            </div>
          </div>
          <div class="column index1">
            <div class="subOrder-wrap">
              <div class="type" v-html="'打弹片: '"></div>
              <div class="wrap">
                <span
                    v-for="(subOrder, index) in orderRelation[order.orderid]"
                    v-if=" subOrder.type===0"
                    :key="index"
                    class="subOrder"
                    :title="subOrder.timeslot.date+ ' ' + subOrder.timeslot.time">
                  {{subOrder.id}}
                </span>
              </div>
            </div>
            <div class="subOrder-wrap">
              <div class="type" v-html="'装&#8194;&#8194;配: '"></div>
              <div class="wrap">
                <span
                    v-for="(subOrder, index) in orderRelation[order.orderid]"
                    v-if=" subOrder.type===1"
                    :key="index"
                    class="subOrder"
                    :title="subOrder.timeslot.date+ ' ' + subOrder.timeslot.time">
                  {{subOrder.id}}
                </span>
              </div>
            </div>
            <div class="subOrder-wrap">
              <div class="type" v-html="'测&#8194;&#8194;试: '"></div>
              <div class="wrap">
                <span
                    v-for="(subOrder, index) in orderRelation[order.orderid]"
                    v-if=" subOrder.type===2"
                    :key="index"
                    class="subOrder"
                    :title="subOrder.timeslot.date+ ' ' + subOrder.timeslot.time">
                  {{subOrder.id}}
                </span>
              </div>
            </div>
          </div>
        </div>
        <div class="noOrder" v-if="allOrder.length===0">无订单-生产单关系表...</div>
      </div>
    </div>
  </div>
</template>

<script>
import {getAllOrder} from "../../api/orderManageApi";
import MessageTip from "../../components/MessageTip";

export default {
  name: "OrderWorkSchedule",
    components: {MessageTip},
    data(){
      return{
          isPC: true,
          allOrder: [],
          orderRelation: {},
          messageState: false,
          messageType: 0,
          message: ''
      }
  },
  methods: {
      solveData: function (subOrders) {
          let that = this;
          this.allOrder.forEach(function (order) {
              let sub = [];
              subOrders.forEach(function (subOrder) {
                  if(subOrder.parent_id === order.orderid){
                      sub.push(subOrder)
                  }
              })
              that.orderRelation[order.orderid] = sub;
          })
      },
      nav: function(id){
          this.$router.push({
              path: '/schedule/order',
              query: {
                  id: id
              }
          }).catch(()=>{
              console.log()
          });
      },
      showMessage: function(type, message){
          this.messageType = type;
          this.message = message;
          this.messageState = true;
          setTimeout(this.hideMessage,2000);
      },
      hideMessage: function(){
          this.messageState = false;
          setTimeout(function () {
              this.messageType = 0;
              this.message = '';
          },600);
      }
  },
  mounted(){
    if(sessionStorage.getItem('equipment')==='Mobile'){
      this.isPC = false;
    }
      let session = JSON.parse(sessionStorage.getItem('subOrders'));
      if(session){
          getAllOrder().then(res=>{
              if(res.flag){
                  this.allOrder = res.data;
                  this.solveData(session);
              }else{
                  this.showMessage(1, '获取订单列表失败！');
              }
          }).catch(err=>{
              console.log(err)
              this.showMessage(1, '获取订单列表失败！');
          })
      }
  }
}
</script>

<style scoped lang="less">
  .main{
    .head{
      margin: 30px 5% 0;
      text-align: left;
      .text{
        font-size: 32px;
        font-weight: bold;
      }
    }
    .container{
      margin: 10px 7%;
      display: flex;
      .table{
        width: 100%;
        .row{
          display: flex;
          border-bottom: 1px solid #e0e0e0;
          padding: 12px 0;
          .column{
            padding: 2px 4px;
            display: flex;
            align-items: center;
            justify-content: center;
          }
          .index0{
            width: 40%;
            .order{
              cursor: pointer;
              .id{
                text-decoration: underline;
              }
            }
          }
          .index1{
            width: 60%;
            display: block;
            .subOrder-wrap{
              display: flex;
              margin: 10px 0;
              .type{
                min-width: 90px;
              }
              .wrap{
                display: block;
                text-align: left;
                .subOrder{
                  margin: 2px 4px;
                  cursor: default;
                }
              }
            }
          }
        }
        .row:first-child{
          border-top: 1px solid #e0e0e0;
          background-color: #f2f2f2;
          font-weight: bold;
        }
        .row:hover{
          background-color: #f0f6f9;
        }
        .noOrder{
          margin-top: 10px;
          font-size: 20px;
        }
      }
    }
  }
  .mobile{
    width: 100vw;
    .head{
      margin: 12px 5% 0;
      text-align: left;
      .text{
        font-size: 16px;
        font-weight: bold;
      }
    }
    .container{
      margin: 10px 5%;
      display: flex;
      .table{
        width: 100%;
        .row{
          display: flex;
          border-bottom: 1px solid #e0e0e0;
          padding: 12px 0;
          .column{
            padding: 2px 4px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 14px;
          }
          .index0{
            width: 50%;
            .order{
              font-size: 12px;
              cursor: pointer;
              .id{
                text-decoration: underline;
              }
            }
          }
          .index1{
            width: 50%;
            display: block;
            .subOrder-wrap{
              display: flex;
              font-size: 12px;
              margin: 2px 0;
              .type{
                min-width: 50px;
              }
              .wrap{
                display: block;
                text-align: left;
                .subOrder{
                  margin: 2px 4px;
                  cursor: default;
                  width: 20px;
                }
              }
            }
          }
        }
        .row:first-child{
          border-top: 1px solid #e0e0e0;
          background-color: #f2f2f2;
          font-weight: bold;
        }
        .row:hover{
          background-color: #f0f6f9;
        }
        .noOrder{
          margin-top: 10px;
          font-size: 20px;
        }
      }
    }
  }
</style>
