<!DOCTYPE HTML>
<html lang="ru">

<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="/css/${"home.css"}">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<#--    <link rel="stylesheet" href="/css/${"home.css"}">-->
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
                                <a href="/confirmed_orders" class="nav-link text-white">
                                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#table"></use></svg>
                                    Заказы
                                </a>
                            <#else>
                                <a href="/orders" class="nav-link text-white">
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
                                <a href="/confirmed_orders" class="nav-link text-white">
                                    <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#grid"></use></svg>
                                    Заказы
                                </a>
                            </#if>
                        </li>
                        <li>
                            <#if session==1>
                            <a href="/customers" class="nav-link text-white">
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
        <div class="px-3 py-2 border-bottom mb-3" >
            <div style="display: flex; align-items: center; justify-content: space-between">
                <div class="container d-flex flex-wrap justify-content-center">
                    <form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto" role="search" action="/home" method="get">
                        <input type="text" name="searchName" class="form-control" placeholder="Поиск..." aria-label="Search">
                    </form>
                </div>
                <div class="container d-flex flex-wrap justify-content-center">
                    <form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto d-flex" action="/home" method="get" style="margin-left: 10px">
                        <select name="sort_by_price" class="custom-select form-select">
                            <option disabled selected>Сортировка...</option>
                            <option value="DESC">По убыванию</option>
                            <option value="ASC">По возрастанию</option>
                        </select>
                        <input class="btn btn-primary" style="margin-left: 30px" type="submit" value="Сортировать">
                    </form>
                </div>
            </div><br>
            <form action="/home" method="get">
                <div style="display: flex; align-items: center; justify-content: space-between">

                    <h3 style="margin-top: 35px">Фильтрация</h3>
                    <div>
                        <h4>Название</h4>
                        <input type="text" name="products_name" class="form-control">
                    </div>
                    <div>
                        <h4>Цена</h4>
                        <div style="display: flex">
                            <input type="text" placeholder="От.." name="min_price" class="form-control" >
                            <input type="text" placeholder="До.." name="max_price" class="form-control" >
                        </div>

                    </div>

                    <div>
                        <h4>Пол</h4>
                        <select name="gender" class="custom-select form-select">
                            <option disabled selected value="Выбор">Выбор</option>
                            <option value="Мужской">Мужское</option>
                            <option value="Женское">Женское</option>
                        </select>
                    </div>
                    <div>
                        <h4>Сезон</h4>
                        <select name="season" class="custom-select form-select">
                            <option disabled selected value="Выбор">Выбор</option>
                            <option value="Зима">Зима</option>
                            <option value="Весна">Весна</option>
                            <option value="Лето">Лето</option>
                            <option value="Осень">Осень</option>
                        </select>
                    </div>
                    <input class="btn btn-primary" style="margin-top: 35px" type="submit" value="Фильтровать">

                </div>
            </form>
        </div>

    </header>
</div> <!--header-->

<#list products as prod>
    <div class="pop" id="myList">
        <a href="products/${prod.id_products}" style="text-decoration: none">
            <div class="card" style="width: 18rem;">
                <img src="/images/${prod.image[0].idImages}" class="card-img-top" alt="...">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">${prod.nameProducts}</li>
                    <li class="list-group-item">${prod.cost} р.</li>
                    <li class="list-group-item">${prod.size} размеры</li>
                </ul>
            </div><br>
        </a>
    </div>
</#list>

</body>
</html>