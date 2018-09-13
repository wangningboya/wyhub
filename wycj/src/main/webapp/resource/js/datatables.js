var datas;
function test() {
    $.post(
        "/findUserPrizeList",
        {},
        function (data,status) {
            if(status=="success"){
                alert("666");
                datas=data;
            }
        },
        "json"
    )
}
function test2() {
    alert("length"+datas.length);
}
function test3() {
        $('#xixi').dataTable({
       data:datas,
    // { "bInfo": false},
        columns: [
                { data: 'userId' },
                { data: 'prizeId' },
                { data: 'state' },
                { data: 'prizeTime' },
            ]
    });
}


//
// $(document).ready(function() {
//     $('#xixi').dataTable({
//        ajax:{
//             url:'/aaaa',
//            dataSrc:'data'
//        },
//         columns: [
//                 { data: 'userId' },
//                 { data: 'prizeId' },
//                 { data: 'state' },
//                 { data: 'id' },
//                 { data: 'isDelete' },
//                 { data: 'prizeTime' }
//             ]
//     });
// } );
