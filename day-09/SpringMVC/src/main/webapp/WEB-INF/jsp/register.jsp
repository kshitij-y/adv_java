<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>

    <style>

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: ui-sans-serif, system-ui, -apple-system, Segoe UI, Roboto, sans-serif;
        }

        body {
            height: 100vh;
            background: #09090b; /* shadcn dark base */
            display: flex;
            justify-content: center;
            align-items: center;
            color: #fafafa;
        }

        .card {
            background: #18181b;
            border: 1px solid #27272a;
            border-radius: 10px;
            padding: 32px;
            width: 340px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.4);
        }

        h2 {
            font-size: 20px;
            font-weight: 500;
            margin-bottom: 24px;
        }

        .field {
            margin-bottom: 18px;
        }

        label {
            display: block;
            font-size: 13px;
            margin-bottom: 6px;
            color: #a1a1aa;
        }

        input {
            width: 100%;
            padding: 10px 12px;
            background: #09090b;
            border: 1px solid #27272a;
            border-radius: 6px;
            color: #fafafa;
            outline: none;
            transition: border 0.15s ease;
        }

        input:focus {
            border-color: #52525b; /* neutral focus, no blue */
        }

        button {
            width: 100%;
            padding: 10px;
            background: #fafafa;
            color: #09090b;
            border: none;
            border-radius: 6px;
            font-weight: 500;
            cursor: pointer;
            transition: opacity 0.15s ease;
        }

        button:hover {
            opacity: 0.85;
        }

    </style>
</head>

<body>

<div class="card">

    <h2>Register</h2>

    <form action="/register" method="post">

        <div class="field">
            <label>Name</label>
            <input type="text" name="name" required />
        </div>

        <div class="field">
            <label>Email</label>
            <input type="email" name="email" required />
        </div>

        <button type="submit">Register</button>

    </form>

</div>

</body>
</html>