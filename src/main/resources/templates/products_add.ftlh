<!DOCTYPE HTML>
<#--<html xmlns:th="http://www.thymeleaf.org">-->
<head>
    <title>Список обуви</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>

<body>

<div>
    <header>
        <div class="px-3 py-2 text-bg-dark">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="/" class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">
                        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
                    </a>

                    <ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
                        <li>
                            <a href="/home" class="nav-link text-secondary">
                                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#home"></use></svg>
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="/add_products" class="nav-link text-white">
                                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#speedometer2"></use></svg>
                                Add products
                            </a>
                        </li>
                        <li>
                            <a href="/" class="nav-link text-white">
                                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#table"></use></svg>
                                Orders
                            </a>
                        </li>
                        <li>
                            <a href="/products" class="nav-link text-white">
                                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#grid"></use></svg>
                                Products
                            </a>
                        </li>
                        <li>
                            <a href="/" class="nav-link text-white">
                                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#people-circle"></use></svg>
                                Customers
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="text-end">
                    <button type="button" class="btn btn-light text-dark me-2">Login</button>
                    <button type="button" class="btn btn-primary">Sign-up</button>
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
    <h1>Добавление пары обуви</h1>
    <form action="/add_products" method="post">
        <input type="text" name="name_products" placeholder="Название обуви" class="form-control"><br>
        <input type="text" name="season" placeholder="Сезон" class="form-control"><br>
        <input type="text" name="amount" placeholder="Количество" class="form-control"><br>
        <input type="text" name="cost" placeholder="Цена" class="form-control"><br>
        <input type="text" name="gender" placeholder="Пол" class="form-control"><br>
        <button type="submit" class="btn btn-success">Добавить пару</button>
    </form>
</div>
</body>
</html>