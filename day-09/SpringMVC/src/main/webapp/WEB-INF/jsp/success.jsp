<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>

    <style>

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: ui-sans-serif, system-ui, -apple-system, Segoe UI, Roboto, sans-serif;
        }

        body {
            height: 100vh;
            background: #09090b;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #fafafa;
        }

        .card {
            background: #18181b;
            border: 1px solid #27272a;
            border-radius: 10px;
            padding: 36px;
            width: 360px;
            text-align: center;
            box-shadow: 0 8px 24px rgba(0,0,0,0.4);
        }

        .icon {
            font-size: 32px;
            margin-bottom: 16px;
            color: #a1a1aa; /* neutral accent, not blue */
        }

        h2 {
            font-size: 20px;
            font-weight: 500;
            margin-bottom: 10px;
        }

        p {
            color: #a1a1aa;
            font-size: 14px;
            margin-bottom: 24px;
        }

        .btn {
            display: inline-block;
            padding: 10px 14px;
            background: #fafafa;
            color: #09090b;
            border-radius: 6px;
            text-decoration: none;
            font-weight: 500;
            font-size: 14px;
            transition: opacity 0.15s ease;
        }

        .btn:hover {
            opacity: 0.85;
        }

    </style>
</head>

<body>

<div class="card">

    <div class="icon">✔</div>

    <h2>Registration Successful</h2>

    <p>Welcome, <strong>${name}</strong>!</p>

    <a href="/register" class="btn">Go Home</a>

</div>

</body>
</html>