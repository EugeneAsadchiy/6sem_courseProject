<!DOCTYPE HTML>
<#--<html xmlns:th="http://www.thymeleaf.org">-->
<head>
    <title>Редактирование пары обуви</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>

<body>

<div>
    <header>
        <div class="px-3 py-2 text-bg-dark">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <#--                    <a href="/" class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">-->
                    <#--                        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>-->
                    <#--                    </a>-->

                    <ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
                        <li>
                            <a href="/home" class="nav-link text-secondary">
                                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#home"></use></svg>
                                Главная
                            </a>
                        </li>
                        <li>
                            <#if session==1>
                                <a href="/add_products" class="nav-link text-white">
                                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#speedometer2"></use></svg>
                                    Добавить обувь
                                </a>
                            </#if>
                        </li>
                        <li>
                            <#if session==1>
                                <a href="/" class="nav-link text-white">
                                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#table"></use></svg>
                                    Заказы
                                </a>
                            <#else>
                                <a href="/" class="nav-link text-white">
                                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#table"></use></svg>
                                    Корзина
                                </a>
                            </#if>
                        </li>
                        <li>
                            <#if session==1>
                                <a href="/products" class="nav-link text-white">
                                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#grid"></use></svg>
                                    Обувь
                                </a>
                            <#else>
                                <a href="/" class="nav-link text-white">
                                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#grid"></use></svg>
                                    ****
                                </a>
                            </#if>
                        </li>
                        <li>
                            <#if session==1>
                                <a href="/" class="nav-link text-white">
                                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#people-circle"></use></svg>
                                    Покупатели
                                </a>
                            <#else>
                                <a href="/" class="nav-link text-white">
                                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#grid"></use></svg>
                                    О нас
                                </a>
                            </#if>
                        </li>
                        <li>
                            <a href="/" class="nav-link text-white" style=" margin-left: 600px">
                                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#people-circle"></use></svg>
                                ${profile}
                            </a>
                            <#--                            <#if session==1>-->

                            <#--                            <#else>-->
                            <#--                                <p>В корзину</p>-->
                            <#--                            </#if>-->
                        </li>
                        <li>
                            <button type="button" class="btn btn-danger text-dark me-2" style="margin-top: 30px; margin-left: 30px">
                                <a href="/authorization" style="color: black; text-decoration: none">Выйти</a>
                            </button>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="px-3 py-2 border-bottom mb-3">
            <div class="container d-flex flex-wrap justify-content-center">
                <form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto" role="search">
                    <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
                </form>
            </div>
        </div>
    </header>
</div> <!--header-->
<div class="container mt-5 mb-5">
    <h1>Редактирование пары обуви</h1>

        <div class="alert alert-info mt-2">
            <form action="/products/${products.id_products}/edit" method="post" enctype="multipart/form-data">
                <input type="text" value="${products.nameProducts}" name="nameProducts" placeholder="Название обуви" class="form-control"><br>
                <input type="text" value="${products.season}" name="season" placeholder="Сезон" class="form-control"><br>
                <input type="text" value="${products.amount}" name="amount" placeholder="Количество" class="form-control"><br>
                <input type="text" value="${products.size}" name="size" placeholder="Размеры" class="form-control"><br>
                <input type="text" value="${products.cost}" name="cost" placeholder="Цена" class="form-control"><br>
                <input type="text" value="${products.gender}" name="gender" placeholder="Пол" class="form-control"><br>
                <input type="file" name="file1" placeholder="Фотография1"><br><br>
                <input type="file" name="file2" placeholder="Фотография2"><br><br>
                <input type="file" name="file3" placeholder="Фотография3"><br><br>
                <button type="submit" class="btn btn-success">Обновить</button>
            </form>
        </div>

</div>

</body>
</html>