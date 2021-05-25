<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/


Auth::routes();

Route::get('/home', [App\Http\Controllers\HRMController::class, 'create'])->name('home');

Route::get('/', [App\Http\Controllers\HRMController::class, 'create'])->name('/');

Route::resource('image', 'App\Http\Controllers\HRMController');

Route::get('/delete/{id}', [App\Http\Controllers\HRMController::class, 'delete'])->name('delete');

Route::post('/store', [App\Http\Controllers\HRMController::class, 'store'])->name('store');

