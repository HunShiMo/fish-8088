layui.use('laydate', function () {
    var laydate = layui.laydate;

    //选中后的回调
    laydate.render({
        elem: '#test',
        // min: '2020-01-01',
        done: function (value, date) {
            // console.log("value=>", value, "date=>", date);
            getHistoryData(value);
        }
    })
})


/**
 * 发送POST请求，获取历史数据
 *
 * @param date 查看这天的历史数据
 * @author ray
 * @date 2021/11/28 19:07
 */
function getHistoryData(date) {
    $.ajax({
        // url: 'http://localhost/historical-data/get-data',
        // url: 'http://150.158.1.149/historical-data/get-data',
        url: 'http://[2001:da8:270:2021::150]:8088/historical-data/get-data',
        type: 'POST',
        dataType: 'json',
        data: "date=" + date,
        success: function (data) {
            // console.log("data=>", data);
            if (data.code === 200) {
                // $.modal.alertSuccess(result.msg)
                myChart1.setOption({
                    visualMap: {
                        min: data.temp_min,
                        max: data.temp_max
                    },
                    series:[
                        {
                            data: data.temp
                        }
                    ]
                });
                myChart2.setOption({
                    visualMap: {
                        min: data.salt_min,
                        max: data.salt_max
                    },
                    series:[
                        {
                            data: data.salt
                        }
                    ]
                })
                myChart3.setOption({
                    visualMap: {
                        min: data.yls_min,
                        max: data.yls_max
                    },
                    series:[
                        {
                            data: data.yls
                        }
                    ]
                })
                myChart4.setOption({
                    visualMap: {
                        min: data.rjy_min,
                        max: data.rjy_max
                    },
                    series:[
                        {
                            data: data.rjy
                        }
                    ]
                })
            } else {
                $.modal.alertError("当天暂无数据");
            }
        }
    })
}

var myChart1 = echarts.init(document.getElementById('temp_line'));
var myChart2 = echarts.init(document.getElementById('salt_line'));
var myChart3 = echarts.init(document.getElementById('yls_line'));
var myChart4 = echarts.init(document.getElementById('rjy_line'));
var option1 = {
    visualMap: {
        show: true,
        type: 'continuous',
        seriesIndex: 0,
        min: 7.1223335,
        max: 9.298834,
        inRange: {
            color: ['#F08080','#A52A2A'],
        },

    },
    title: {
        left: 'center',
        text: '温度表'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        },
    },
    xAxis: {
        name: '时间',
        type: 'category',
        axisTick: {
            alignWithLabel: true
        },
        axisLabel: {
            align: 'center',
            interval: 1,
        },
        splitLine: {
            show: true
        },
        data: ['0时', '1时', '2时', '3时', '4时', '5时', '6时', '7时', '8时', '9时', '10时', '11时', '12时', '13时', '14时', '15时', '16时', '17时', '18时', '19时', '20时', '21时', '22时', '23时']
    },
    yAxis: {
        type: 'value',
        scale: true
    },
    series: [
        {
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        { offset: 0, color: "#B22222" },
                        { offset: 0.5, color: "#FF7F50" },
                        { offset: 1, color: "#FAEBD7" }
                    ])
                }
            }, //填充区域样式

            symbol: 'circle', // 设置标记的图形为circle
            smooth: true,
            type: 'line',
            showSymbol: true,
            data: [8.699, 7.7194996, 7.4475, 7.2641673, 7.1223335, 7.3243337, 7.5889993, 8.429167, 8.7165, 8.846667, 8.964834, 8.9800005, 8.805667, 8.953334, 9.091333, 9.298834, 9.275833, 8.820834, 8.941501, 8.888501, 8.3376665, 8.5720005, 8.530833, 8.4862]
        }
    ]
};
var option2 = {
    visualMap: {
        show: true,
        type: 'continuous',
        seriesIndex: 0,
        min: 31.935564,
        max: 32.01002,
        inRange: {
            color: ['#AFEEEE', '#000080']
        }
    },
    title: {
        left: 'center',
        text: '盐度表'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        },
    },
    xAxis: {
        name: '时间',
        type: 'category',
        axisTick: {
            alignWithLabel: true
        },
        axisLabel: {
            align: 'center',
            interval: 1,

        },
        data: ['0时', '1时', '2时', '3时', '4时', '5时', '6时', '7时', '8时', '9时', '10时', '11时', '12时', '13时', '14时', '15时', '16时', '17时', '18时', '19时', '20时', '21时', '22时', '23时']
    },
    yAxis: {
        type: 'value',
        scale: true
    },
    series: [
        {
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        { offset: 0, color: "#4169E1" },
                        { offset: 0.5, color: "#87CEFA" },
                        { offset: 1, color: "#E1FFFF" }
                    ])
                }
            }, //填充区域样式
            symbol: 'circle', // 设置标记的图形为circle
            smooth: true,
            type: 'line',
            showSymbol: true,
            data: [31.968567, 31.97975, 31.98345, 31.984, 31.984385, 31.98165, 31.987665, 31.979149, 31.978752, 31.980734, 31.982916, 31.971048, 31.949766, 31.94295, 31.935564, 31.951899, 31.9487, 31.937284, 31.957148, 31.983932, 31.98185, 32.00567, 32.00658, 32.01002]
        }
    ]
};
var option3 = {
    visualMap: {
        show: true,
        type: 'continuous',
        seriesIndex: 0,
        min: 4.9631867,
        max: 19.558817,
        inRange: {
            color: ['#3CB371', '#006400']
        }
    },
    title: {
        left: 'center',
        text: '叶绿素表'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        },
    },
    xAxis: {
        name: '时间',
        type: 'category',
        axisTick: {
            alignWithLabel: true
        },
        axisLabel: {
            align: 'center',
            interval: 1,

        },
        data: ['0时', '1时', '2时', '3时', '4时', '5时', '6时', '7时', '8时', '9时', '10时', '11时', '12时', '13时', '14时', '15时', '16时', '17时', '18时', '19时', '20时', '21时', '22时', '23时']
    },
    yAxis: {
        type: 'value',
        scale: true
    },
    series: [
        {
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        { offset: 0, color: "#006400" },
                        // { offset: 0.5, color: "#ADFF2F" },
                        { offset: 1, color: "#90EE90" }
                    ])
                }
            }, //填充区域样式
            symbol: 'circle', // 设置标记的图形为circle
            smooth: true,
            type: 'line',
            showSymbol: true,
            data: [17.904078, 5.7071033, 7.9359727, 8.275875, 6.5262303, 6.5978417, 4.9631867, 17.553177, 19.5382, 19.558817, 19.5304, 17.623499, 8.349067, 6.6337814, 6.28553, 13.145817, 19.512516, 19.266317, 17.940466, 18.655983, 19.529833, 18.288399, 19.481916, 19.45222]
        }
    ]
};
var option4 = {
    visualMap: {
        show: true,
        type: 'continuous',
        seriesIndex: 0,
        min: 7.1223335,
        max: 9.298834,
        inRange: {
            color: ['#DCDCDC', '#696969']
        }
    },
    title: {
        left: 'center',
        text: '溶解氧表'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        },
    },
    xAxis: {
        name: '时间',
        type: 'category',
        axisTick: {
            alignWithLabel: true
        },
        axisLabel: {
            align: 'center',
            interval: 1,

        },
        data: ['0时', '1时', '2时', '3时', '4时', '5时', '6时', '7时', '8时', '9时', '10时', '11时', '12时', '13时', '14时', '15时', '16时', '17时', '18时', '19时', '20时', '21时', '22时', '23时']
    },
    yAxis: {
        type: 'value',
        scale: true
    },
    series: [
        {
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        { offset: 0, color: "#808080" },
                        { offset: 0.5, color: "#C0C0C0" },
                        { offset: 1, color: "#F5F5F5" }
                    ])
                }
            }, //填充区域样式
            symbol: 'circle', // 设置标记的图形为circle
            smooth: true,
            type: 'line',
            showSymbol: true,
            data: [8.699, 7.7194996, 7.4475, 7.2641673, 7.1223335, 7.3243337, 7.5889993, 8.429167, 8.7165, 8.846667, 8.964834, 8.9800005, 8.805667, 8.953334, 9.091333, 9.298834, 9.275833, 8.820834, 8.941501, 8.888501, 8.3376665, 8.5720005, 8.530833, 8.4862]
        }
    ]
};
myChart1.setOption(option1, true);
myChart2.setOption(option2, true);
myChart3.setOption(option3, true);
myChart4.setOption(option4, true);
