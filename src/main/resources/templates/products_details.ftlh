<!DOCTYPE HTML>
<html lang="ru">
<head>
    <title>Список обуви</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" defer></script>
<#--    <script src="js/script.js" defer></script>-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
        <div class="px-3 py-2 border-bottom mb-3">
            <div class="container d-flex flex-wrap justify-content-center">
                <form class="col-12 col-lg-auto mb-2 mb-lg-0 me-lg-auto" role="search" action="/home" method="get">
                    <input type="text" name="searchName" class="form-control" placeholder="Поиск..." aria-label="Search">
                </form>
            </div>
        </div>
    </header>
</div> <!--header-->

<div class="container mt-50">


    <div style="display: flex; width: 50rem">
        <div class="card" style="margin-right: 20px">
            <img src="/images/${products.image[0].idImages}" class="card-img-top" alt="..." >
        </div>
        <div class="card" style="margin-right: 20px">
            <img src="/images/${products.image[1].idImages}" class="card-img-top" alt="..." >
        </div>
        <div class="card" style="">
            <img src="/images/${products.image[2].idImages}" class="card-img-top" alt="...">
        </div>
    </div>

    <div>
        <p> Название: ${products.nameProducts}</p>
        <p> Пол: ${products.gender}</p>
        <#if session==1>
            <p> Количество: ${products.amount}</p>
        </#if>
        <p> Размеры: ${products.size}</p>
        <p> Цена: ${products.cost}</p>
        <p> Сезон: ${products.season}</p>

        <#if session==1>
            <div style="display: flex">
                <div style="margin-right: 30px">
                    <a href="/products/${products.id_products}/edit" class="btn btn-warning">Редактировать</a>
                </div>
                <div>
                    <form action="/products/${products.id_products}/remove" method="post">
                        <button class="btn btn-warning" type="submit">Удалить</button>
                    </form>
                </div>

            </div><br>
        <#else>
        <form action="/products/${products.id_products}/order" method="post">
            <label style="display: flex">
                <p>Выберите желаемый размер:</p>
                <select name="size">
<#--                    <option>Выберите размер</option>-->
                <#list size_array as size_list>
                    <option value="${size_list}">${size_list}</option>
                </#list>
                </select>
            </label>

                <button class="btn btn-warning" type="submit">В корзину</button><br><br>
        </form>
        </#if>

    </div>
<#--    </#list>-->

</div>

</body>
</html>