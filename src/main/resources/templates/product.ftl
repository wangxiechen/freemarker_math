<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title></title>
</head>
<body>
<#assign age = 10>
<#assign sort = [9,8,6,4,3,8,2,1,5,7]>
<h1>hello,${name}</h1>
<h2>年龄,${age}</h2>
<#assign str = "1232255addcd">
<h3>长度,${str?length}</h3>
<h3>截取,${str?substring(2,6)}</h3>
<#assign list = ["李忠宇","王燮晨","最漂亮"]>
<h3><#list list as item>
    ${item}
</#list></h3>
--------不规则排序------
<h3><#list sort as item>
    ${item}
</#list></h3>
--------规则升序------
<h3><#list sort_int(sort) as item>
    ${item}
</#list></h3>

</body>
</html>