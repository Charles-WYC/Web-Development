<?php

use yii\helpers\Html;
use yii\widgets\DetailView;

/* @var $this yii\web\View */
/* @var $model app\models\Bookstack */

$this->title = $model->bookID;
$this->params['breadcrumbs'][] = ['label' => 'Bookstacks', 'url' => ['index']];
$this->params['breadcrumbs'][] = $this->title;
?>
<div class="bookstack-view">

    <h1><?= Html::encode($this->title) ?></h1>

    <p>
        <?= Html::a('Update', ['update', 'id' => $model->bookID], ['class' => 'btn btn-primary']) ?>
        <?= Html::a('Delete', ['delete', 'id' => $model->bookID], [
            'class' => 'btn btn-danger',
            'data' => [
                'confirm' => 'Are you sure you want to delete this item?',
                'method' => 'post',
            ],
        ]) ?>
    </p>

    <?= DetailView::widget([
        'model' => $model,
        'attributes' => [
            'bookID',
            'price',
            'quantity',
            'book_name',
        ],
    ]) ?>

</div>
