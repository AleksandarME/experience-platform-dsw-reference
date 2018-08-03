/*
 *  Copyright 2017 Adobe.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.platform.ml

import com.adobe.platform.ml.config.ConfigProperties
import com.adobe.platform.ml.sdk.PipelineFactory
import ml.dmlc.xgboost4j.scala.Booster
import ml.dmlc.xgboost4j.scala.spark.XGBoost
import org.apache.spark.ml.Pipeline
import ml.dmlc.xgboost4j.scala.spark.{XGBoostEstimator}

/**
  * Main Pipeline configuration class that outlines the xgboost pipeline stages
  */
class XGBoostPipeline extends PipelineFactory {

  /**
    * Implementation of pipeline factory to configure the pipeline with
    * xgboost stages.
    * @param configProperties Properties map from the pipeline.json
    * @return
    */
  override def apply(configProperties: ConfigProperties) = {
    // Configure an ML pipeline
    val num_rounds: Int = configProperties.get("num_rounds").get.toInt

    // construct the pipeline
    val pipeline = new Pipeline().setStages(Array(new XGBoostEstimator(Map[String, Any]("num_rounds" -> num_rounds))))

    pipeline
  }
}
