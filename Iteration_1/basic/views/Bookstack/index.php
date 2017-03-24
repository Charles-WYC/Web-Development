<?php

use yii\helpers\Html;
use yii\grid\GridView;

/* @var $this yii\web\View */
/* @var $searchModel app\models\BookstackSearch */
/* @var $dataProvider yii\data\ActiveDataProvider */

$this->title = 'Bookstacks';
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="bookstack-index">

    <h1><?= Html::encode($this->title) ?></h1>
    <?php // echo $this->render('_search', ['model' => $searchModel]); ?>

    <p>
        <?= Html::a('Create Bookstack', ['create'], ['class' => 'btn btn-success']) ?>
    </p>
    <?= GridView::widget([
        'dataProvider' => $dataProvider,
        'filterModel' => $searchModel,
        'columns' => [
            ['class' => 'yii\grid\SerialColumn'],

            'bookID',
            'price',
            'quantity',
            'book_name',

            ['class' => 'yii\grid\ActionColumn'],
        ],
    ]); ?>
</div>
